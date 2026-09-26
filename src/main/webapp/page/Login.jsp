<%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 9/26/2026
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="Login" method="post" style="max-width: 450px; margin: 20px auto; font-family: Tahoma, sans-serif; padding: 25px; border: 1px solid #ddd; border-radius: 10px; background-color: #f9f9f9;">

    <h2 style="text-align: center; color: #333; margin-top: 0;">فرم ثبت‌نام</h2>

    <!-- تکرار برای فیلدها -->
    <div style="margin-bottom: 15px;">
        <label style="display: block; margin-bottom: 5px; font-weight: bold;">نام کاربری</label>
        <input type="text" name="username" placeholder="Username" required
               style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box;">
    </div>

    <div style="margin-bottom: 15px;">
        <label style="display: block; margin-bottom: 5px; font-weight: bold;">رمز عبور</label>
        <input type="password" name="password" placeholder="Password" required
               style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box;">
    </div>

    <div style="margin-bottom: 15px;">
        <label style="display: block; margin-bottom: 5px; font-weight: bold;">نام و نام خانوادگی</label>
        <input type="text" name="fullname" placeholder="Full Name" required
               style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box;">
    </div>

    <div style="margin-bottom: 15px;">
        <label style="display: block; margin-bottom: 5px; font-weight: bold;">شماره تماس</label>
        <input type="number" name="phonenumber" placeholder="Phone Number" required
               style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box;">
    </div>

    <div style="display: flex; gap: 10px;">
        <div style="flex: 1; margin-bottom: 15px;">
            <label style="display: block; margin-bottom: 5px; font-weight: bold;">شهر</label>
            <input type="text" name="city" placeholder="City"
                   style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box;">
        </div>
        <div style="flex: 1; margin-bottom: 15px;">
            <label style="display: block; margin-bottom: 5px; font-weight: bold;">کد پستی</label>
            <input type="text" name="zipcode" placeholder="Zipcode"
                   style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box;">
        </div>
    </div>

    <div style="margin-bottom: 15px;">
        <label style="display: block; margin-bottom: 5px; font-weight: bold;">خیابان</label>
        <input type="text" name="street" placeholder="Street"
               style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box;">
    </div>

    <div style="margin-bottom: 20px;">
        <label style="display: block; margin-bottom: 5px; font-weight: bold;">موجودی</label>
        <input type="number" name="balance" placeholder="Balance"
               style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box;">
    </div>

    <button type="submit"
            style="width: 100%; padding: 12px; background-color: #28a745; color: white; border: none; border-radius: 5px; font-size: 16px; cursor: pointer; font-weight: bold;">
        ثبت‌نام
    </button>
</form>
</body>
</html>
