using System.Collections;
using System.Collections.Generic;
using UnityEditor;
using UnityEditor.Animations;
using UnityEngine;
using UnityEngine.UI;

public class RealFighter : MonoBehaviour
{
    // Start is called before the first frame update

    public float moveSpeed = 5.0f;
    public GameObject healthBarPrefab; // 拖拽分配到 HealthBarPrefab 预制件
    public Canvas uiCanvas; // 拖拽分配到场景中的 Canvas
    public Vector3 healthBarOffset = new Vector3(0, 2, 0); // 血量条相对于物体的位置偏移

    private GameObject healthBarInstance;
    private RectTransform redBarRectTransform; // 红色血量条的 RectTransform
    private float maxHealth = 100f;
    private float currentHealth;
    private Vector3 redBarPos;
    void Start()
    {
        currentHealth = maxHealth;
        // 在 Canvas 上生成 HealthBar 实例
        healthBarInstance = Instantiate(healthBarPrefab, uiCanvas.transform);

        healthBarInstance.GetComponent<Image>().color = Color.white;
        healthBarInstance.transform.Find("RedBar").GetComponent<Image>().color = Color.red;
        redBarPos = healthBarInstance.transform.Find("RedBar").localPosition;
        redBarRectTransform = healthBarInstance.transform.Find("RedBar").GetComponent<RectTransform>();

        UpdateHealthBar();
    }

    void UpdateHealthBar()
    {
        float healthPercentage = currentHealth / maxHealth;

        // 根据健康比例调整红色血量条的宽度
        if (redBarRectTransform != null)
        {
            redBarRectTransform.localScale = new Vector3(healthPercentage, 1f, 1f);
        }
    }
    private GameObject weapon;
    public void TakeWeapon(GameObject weaponPrefab)
    {
        Transform rightHand = FindChildRecursive(gameObject.transform, "mixamorig:RightHand");
        weapon = Instantiate(weaponPrefab, rightHand.position,  Quaternion.Euler(14,-6,154));
        
    }
    public void TakeDamage(float damage)
    {
        currentHealth -= damage;
        currentHealth = Mathf.Clamp(currentHealth, 0, maxHealth);
        UpdateHealthBar();
    }
    // Update is called once per frame
    public bool isDead()
    {
        return currentHealth <= 0;
    }

    bool FirstDead = true;
    void UpdateHealth()
    {
        if (!isDead())
        {

            float ratio = currentHealth / maxHealth;
            if (healthBarInstance != null)
            {
                Vector3 screenPosition = Camera.main.WorldToScreenPoint(transform.position + healthBarOffset);
                healthBarInstance.transform.position = screenPosition;
            }
        }

        if (currentHealth <= 0f && FirstDead)
        {
            FirstDead = false;
            // 销毁健康条实例
            if (healthBarInstance != null)
            {
                Destroy(healthBarInstance);
            }
            gameObject.GetComponent<Animator>().enabled = false;
            SetAllRigidbodiesKinematic(gameObject, false);
            AddForce(new Vector3(0, 300, 0), "mixamorig:Hips", ForceMode.Impulse);
        }

    }

    public void AddForce(Vector3 forceDirection, string targetBoneName, ForceMode forceMode)
    {
        Transform targetBone = FindChildRecursive(gameObject.transform, targetBoneName);
        Rigidbody rb = targetBone.GetComponent<Rigidbody>();
        rb.AddForce(forceDirection, forceMode);
    }

    Transform FindChildRecursive(Transform parent, string targetBoneName)
    {
        // 检查当前物体是否匹配目标名称
        if (parent.name == targetBoneName)
        {
            return parent;
        }

        // 遍历当前物体的所有子物体
        foreach (Transform child in parent)
        {
            Transform result = FindChildRecursive(child, targetBoneName);
            if (result != null)
            {
                return result;
            }
        }

        // 如果没有找到匹配的子物体，返回 null
        return null;
    }

    void SetAllRigidbodiesKinematic(GameObject obj, bool state)
    {
        // 获取当前物体的Rigidbody组件（如果有的话）
        Rigidbody rb = obj.GetComponent<Rigidbody>();
        if (rb != null)
        {
            rb.isKinematic = state;
        }

        // 递归查找并处理子物体中的Rigidbody
        foreach (Transform child in obj.transform)
        {
            SetAllRigidbodiesKinematic(child.gameObject, state);
        }
    }


    // Update is called once per frame
    void Update()
    {
        UpdateHealth();
        FindFighter();


        Transform rightHand = FindChildRecursive(gameObject.transform, "mixamorig:RightHand");
        if (weapon != null)
        {
            weapon.transform.position = rightHand.position;
        }
    }

    private void FixedUpdate()
    {
    }

    void FindFighter()
    {
        // 找到所有带有 Fighter 组件的对象
        Fighter[] fighters = FindObjectsOfType<Fighter>();

        if (fighters.Length > 0)
        {
            // 选择最近的目标
            Transform closestTarget = null;
            float closestDistance = Mathf.Infinity;

            foreach (Fighter fighter in fighters)
            {
                // 排除自己
                if (fighter.gameObject == this.gameObject)
                    continue;

                float distanceToTarget = Vector3.Distance(transform.position, fighter.transform.position);
                if (distanceToTarget < closestDistance && distanceToTarget > 1)
                {
                    closestDistance = distanceToTarget;
                    closestTarget = fighter.transform;
                }
            }

            // 向最近的目标移动
            if (closestTarget != null)
            {
                Vector3 direction = (closestTarget.position - transform.position).normalized;
                transform.position += direction * moveSpeed * Time.deltaTime;
            }
        }
    }


}
