package com.cyy.takeout.utils;

import java.io.Serializable;
import com.aliyun.tea.*;
public class MessageSendUtil implements Serializable {
    
    
        public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
            com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                    // 必填，您的 AccessKey ID
                    .setAccessKeyId(accessKeyId)
                    // 必填，您的 AccessKey Secret
                    .setAccessKeySecret(accessKeySecret);
            // 访问的域名
            config.endpoint = "dysmsapi.aliyuncs.com";
            return new com.aliyun.dysmsapi20170525.Client(config);
        }

        public static void sendMsg(String phone,String param) throws Exception {
            // 工程代码泄露可能会导致AccessKey泄露，并威胁账号下所有资源的安全性。以下代码示例仅供参考，建议使用更安全的 STS 方式，更多鉴权访问方式请参见：https://help.aliyun.com/document_detail/378657.html
            com.aliyun.dysmsapi20170525.Client client = MessageSendUtil.createClient("LTAI5tK93BEmQPw8usrZBrK6", "wMw0FKf3ovcAriaWpb4RgizlKyl4Cv");
            com.aliyun.dysmsapi20170525.models.SendSmsRequest sendSmsRequest = new com.aliyun.dysmsapi20170525.models.SendSmsRequest()
                    .setPhoneNumbers(phone)
                    .setSignName("rikka")
                    .setTemplateCode("SMS_262380350")
                    .setTemplateParam("{\"code\":"+"\""+param+"\"}");
            try {
                // 复制代码运行请自行打印 API 的返回值
                client.sendSmsWithOptions(sendSmsRequest, new com.aliyun.teautil.models.RuntimeOptions());
            } catch (TeaException error) {
                // 如有需要，请打印 error
                com.aliyun.teautil.Common.assertAsString(error.message);
            } catch (Exception _error) {
                TeaException error = new TeaException(_error.getMessage(), _error);
                // 如有需要，请打印 error
                com.aliyun.teautil.Common.assertAsString(error.message);
            }
        }
        


}
