using System.Collections;
using System.Collections.Generic;
using Unity.VisualScripting;
using UnityEditor;
using UnityEditor.Animations;
using UnityEngine;

public class TwoBattleGround : MonoBehaviour
{

    private GameObject selectedPrefab;
    private GameObject generatedAnimal;
    public Canvas uiCanvas; // 拖拽分配到场景中的 Canvas
    public GameObject healthBarPrefab; // 拖拽分配到 HealthBarPrefab 预制件


    private string folderPath = "Assets/Characters/RagdollPrefabs"; // 资源所在文件夹的路径
    // Start is called before the first frame update
    void Start()
    {
        SelectRandomCharacter(new Vector3(0, -18.5f, -16f));
        SelectRandomCharacter(new Vector3(30, -18.5f, -16f));

        SelectRandomGun();
    }

    AnimationClip RandomClip()
    {
        string[] guids = AssetDatabase.FindAssets("t:AnimationClip", new[] { "Assets/Animations/FightAnimations" });
        Debug.Log(" animations clips length = " + guids.Length);
        AnimationClip clip = new AnimationClip();
        if (guids.Length > 0)
        {
            // 随机选择一个 .anim 文件
            int randomIndex = Random.Range(0, guids.Length);
            string path = AssetDatabase.GUIDToAssetPath(guids[randomIndex]);
            // 加载 AnimationClip 并赋值
            clip = AssetDatabase.LoadAssetAtPath<AnimationClip>(path);
        }
        return clip;
    }
    void SelectRandomCharacter(Vector3 pos)
    {
        // 查找指定文件夹下的所有 Prefab
        string[] guids = AssetDatabase.FindAssets("t:Prefab", new[] { folderPath });


        if (guids.Length > 0)
        {
            // 随机选择一个 Prefab 文件
            int randomIndex = Random.Range(0, guids.Length);
            string path = AssetDatabase.GUIDToAssetPath(guids[randomIndex]);
            selectedPrefab = AssetDatabase.LoadAssetAtPath<GameObject>(path);
            generatedAnimal = Instantiate(selectedPrefab, pos, Quaternion.identity);


            generatedAnimal.GetComponent<Fighter>().enabled = false;
            generatedAnimal.AddComponent<RealFighter>();
            generatedAnimal.GetComponent<RealFighter>().uiCanvas = uiCanvas;

            generatedAnimal.GetComponent<RealFighter>().healthBarPrefab = healthBarPrefab;
            generatedAnimal.GetComponent<RealFighter>().TakeWeapon(SelectRandomGun());
            float r = Random.Range(2, 4);
            selectedPrefab.transform.localScale = new Vector3(r, r, r);

            AnimatorController controller = new AnimatorController();
            controller.AddLayer("Base Layer");
            AnimatorState state = controller.layers[0].stateMachine.AddState("Default State");
            state.motion = RandomClip();
            generatedAnimal.GetComponent<Animator>().runtimeAnimatorController = controller;
        }
        else
        {
            Debug.LogWarning("No Prefabs found in the folder: " + folderPath);
        }
    }

    GameObject SelectRandomGun()
    {
        // 查找指定文件夹下的所有 Prefab
        string[] guids = AssetDatabase.FindAssets("t:Prefab", new[] { "Assets/Animations/Weapon" });

        if (guids.Length > 0)
        {
            // 随机选择一个 Prefab 文件
            int randomIndex = Random.Range(0, guids.Length);
            string path = AssetDatabase.GUIDToAssetPath(guids[randomIndex]);
            GameObject weapon = AssetDatabase.LoadAssetAtPath<GameObject>(path);
            return weapon;
        }
        return null;
    }
}
