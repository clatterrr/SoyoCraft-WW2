using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bomb : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame

    public Vector3 moveDirection = new Vector3 (0f, 0f, 1f);
    public float moveSpeed = 15.0f;

    public Vector3 forceDirection = new Vector3(0, 0, 10); // 力的方向和大小
    public ForceMode forceMode = ForceMode.Impulse; // 力的模式
    public string targetBoneName = "mixamorig:Hips"; // 施加力的骨骼名称

    private bool couldTakeDamage = true;
    void Update()
    {
        Vector3 movement = moveDirection.normalized * moveSpeed * Time.deltaTime;

        // 移动物体
        transform.Translate(movement, Space.World);

        
    }

    void OnTriggerStay(Collider other)
    {
        if (couldTakeDamage)
        {
            couldTakeDamage = false;
        }
        else
        {
            return;
        }
        Debug.Log(" trigger entered");
        // 检查碰撞到的物体是否带有Fighter组件
        Fighter fighter = other.GetComponent<Fighter>();
        if (fighter != null)
        {
            Debug.Log("hitted");
            
            fighter.TakeDamage(50f);
            // 在Ragdoll中找到目标骨骼
            Transform targetBone = other.gameObject.transform.Find(targetBoneName);

            if (targetBone == null)
            {
                Debug.LogError($"No bone named {targetBoneName} found in the Ragdoll.");
                return;
            }

            Rigidbody rb = targetBone.GetComponent<Rigidbody>();

            if (rb == null)
            {
                Debug.LogError("No Rigidbody component found on the target bone.");
                return;
            }

            // 向骨骼施加力
            rb.AddForce(forceDirection, forceMode);
        }
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
}
