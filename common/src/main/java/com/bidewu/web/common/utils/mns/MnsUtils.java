//package com.bidewu.web.common.utils.mns;
//
//import com.aliyun.mns.client.CloudQueue;
//import com.aliyun.mns.client.MNSClient;
//import com.aliyun.mns.common.ClientException;
//import com.aliyun.mns.common.ServiceException;
//import com.aliyun.mns.model.Message;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * @author WuShoulei
// * @Date 2019/1/23 17:42
// */
//@Service
//public class MnsUtils {
//
//    private static Logger logger = LoggerFactory.getLogger(MnsUtils.class);
//
//    @Autowired
//    private MNSClient client;
//
//    public void sendMessage(String queueName, String msg) {
//        try {
//            CloudQueue queue = client.getQueueRef(queueName);
//            Message message = new Message();
//            message.setMessageBody(msg);
//            Message putMsg = queue.putMessage(message);
//            logger.info("Send message id is: " + putMsg.getMessageId());
//
//        } catch (ClientException ce) {
//            logger.error("Something wrong with the network connection between client and MNS service."
//                    + "Please check your network and DNS availablity.");
//            ce.printStackTrace();
//        } catch (ServiceException se) {
//            se.printStackTrace();
//            logger.error("MNS exception requestId:" + se.getRequestId(), se);
//            if (se.getErrorCode() != null) {
//                if (se.getErrorCode().equals("QueueNotExist")) {
//                    logger.error("Queue is not exist.Please create before use");
//                } else if (se.getErrorCode().equals("TimeExpired")) {
//                    logger.error("The request is time expired. Please check your local machine timeclock");
//                }
//            /*
//            you can get more MNS service error code from following link:
//            https://help.aliyun.com/document_detail/mns/api_reference/error_code/error_code.html
//            */
//            }
//        } catch (Exception e) {
//            logger.error("Unknown exception happened!");
//            e.printStackTrace();
//        }
//
//        //程序退出时，需主动调用client的close方法进行资源释放
////        client.close();
//    }
//}
