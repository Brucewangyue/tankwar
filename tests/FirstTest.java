import com.bruce.tank.core.Tank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FirstTest {
    @Test
    public void test() {
        try {
            // Tank.class 是找到在内存中Class类的实例
            // 通过Class类的实例找到ClassLoader
            // 然后再在classpath中找文件

            assertEquals(FirstTest.class.getClassLoader(),Tank.class.getClassLoader());

            InputStream resourceAsStream = Tank.class.getClassLoader().getResourceAsStream("images/bulletD.gif");
            BufferedImage bufferedImage = ImageIO.read(resourceAsStream);
            assertNotNull(bufferedImage);

            BufferedImage bufferedImage1 = ImageIO.read(new File("src/images/bulletD.gif"));
            assertNotNull(bufferedImage1);

            BufferedImage bufferedImage2 = ImageIO.read(FirstTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            assertNotNull(bufferedImage2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_02(){
        Language l = new Language();
        Man man = new Man(l);
        System.out.println(l);
        man.sayHi();
    }
}
