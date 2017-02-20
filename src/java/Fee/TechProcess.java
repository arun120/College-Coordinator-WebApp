/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fee;

import com.tp.pg.util.TransactionRequestBean;

/**
 *
 * @author Home
 */
public class TechProcess {
    
   private static String reqtype="T";
   private static String merchantCode="T100690";
   private String refno;
   private String amount;
   private static String curCode="INR";
   private String ReturnURL;
   private static String WebServiceLocator="https://www.tpsl-india.in/PaymentGateway/services/TransactionDetailsNew";
   private String CustID;
   private static String encKey="1672673692SHFPHU";
   private static String IV="2632355530WMVBPU";
   private String resMessage;
   private String resMerchantCode;

    public String getResMessage() {
        return resMessage;
    }

    public void setResMessage(String resMessage) {
        this.resMessage = resMessage;
    }

    public String getResMerchantCode() {
        return resMerchantCode;
    }

    public void setResMerchantCode(String resMerchantCode) {
        this.resMerchantCode = resMerchantCode;
    }
   private TransactionRequestBean  reqBean;
    public String getReqtype() {
        return reqtype;
    }

    

    public String getMerchantCode() {
        return merchantCode;
    }

   

    public String getRefno() {
        return refno;
    }

    public void setRefno(String refno) {
        this.refno = refno;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurCode() {
        return curCode;
    }

   

    public String getReturnURL() {
        return ReturnURL;
    }

    public void setReturnURL(String ReturnURL) {
        this.ReturnURL = ReturnURL;
    }


    public String getWebServiceLocator() {
        return WebServiceLocator;
    }



    public String getCustID() {
        return CustID;
    }

    public void setCustID(String CustID) {
        this.CustID = CustID;
    }
    
    
    public String  getRedirectURL(){
        String URL;
        reqBean=new TransactionRequestBean();
        reqBean.setStrRequestType("T");
        reqBean.setStrMerchantCode(merchantCode);
        reqBean.setMerchantTxnRefNumber(refno);
        reqBean.setStrAmount(amount);
        reqBean.setStrCurrencyCode("INR");
        reqBean.setStrReturnURL(ReturnURL);
        reqBean.setWebServiceLocator(WebServiceLocator);
        reqBean.setCustID(CustID);
        reqBean.setKey(encKey.getBytes());
        reqBean.setIv(IV.getBytes());
        reqBean.setStrITC("email:portal@stjosephstechnology.ac.in");
        reqBean.setStrMobileNumber("9445155260");
        reqBean.setStrCustomerName("Arun");
        reqBean.setStrTimeOut("1000");
        reqBean.setCustID("19872627");
        reqBean.setStrBankCode("180");
        reqBean.setAccountNo("1");
        URL=reqBean.getTransactionToken();
        
    return URL;
    }
    
}
