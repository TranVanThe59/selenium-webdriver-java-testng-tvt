package testng;

import org.testng.Assert;

public class Topic_01_Assertion {

    static void main() {
        // 3 hàm chính để kiểm tra tính đúng đắn của dữ liệu
        boolean gender = 3 < 5;
        // Kiểm tra dữ liệu nó phải ĐÚNG
        Assert.assertTrue(gender);

        // Kiểm tra dữ liệu nó phải SAI
        Assert.assertFalse(gender);

        // Kiểm tra dữ liệu nó phải  = với mong đợi (Actual - Expect)
        // Kiểuđữ liệu giống nhau
        // Giá trị của dữ liệu bằng nhau
        Assert.assertEquals(5,6);
        Assert.assertEquals("Name","Name");
        Assert.assertEquals(5,"Name");

    }
}
