from volcenginesdkarkruntime import Ark

# Authentication
# 1.If you authorize your endpoint using an API key, you can set your api key to environment variable "ARK_API_KEY"
# or specify api key by Ark(api_key="${YOUR_API_KEY}").
# Note: If you use an API key, this API key will not be refreshed.
# To prevent the API from expiring and failing after some time, choose an API key with no expiration date.

# 2.If you authorize your endpoint with Volcengine Identity and Access Management（IAM), set your api key to environment variable "VOLC_ACCESSKEY", "VOLC_SECRETKEY"
# or specify ak&sk by Ark(ak="${YOUR_AK}", sk="${YOUR_SK}").
# To get your ak&sk, please refer to this document([https://www.volcengine.com/docs/6291/65568](https://www.volcengine.com/docs/6291/65568))
# For more information，please check this document（[https://www.volcengine.com/docs/82379/1263279](https://www.volcengine.com/docs/82379/1263279)）
client = Ark(api_key="8e4f0b04-0dbb-4290-93b4-8d9d0e7eb2b2")

# 自己记坐标，手写

# Non-streaming:
print("----- standard request -----")
completion = client.chat.completions.create(
    model="ep-20240708162554-qxd89",
    messages = [
        {"role": "system", "content": "你是豆包，是由字节跳动开发的 AI 人工智能助手"},
        {"role": "user", "content": "\"我在大街上吃饭\"。主语是“我”，动作是“吃饭”。格式化输出是”[我，吃饭]“。如果有两个动作，例如“我看着钱陷入了沉思”，那么要输出两个，即\"[我，看],[我，沉思]\"那么“季时川临死前突然意识到自己是注定被主角团打脸的反派。”，格式化输出"},
    ],
)
print(completion.choices[0].message.content)
