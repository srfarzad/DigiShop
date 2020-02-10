// PaymentService.aidl
package com.navin.digishop;

// Declare any non-default types here with import statements

interface PaymentService {

   void payment(String price);
   void login(String username , String password);
   void isLogin();
   void logout();
   void invoice();
}
