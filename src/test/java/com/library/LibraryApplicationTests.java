package com.library;

import com.library.dao.BorrowBookDao;
import com.library.entities.Book;
import com.library.service.BorrowBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@SpringBootTest
class LibraryApplicationTests {

    @Test
    void contextLoads() {
    }

    public void add() {
        Integer price = (int) (Math.random() * 10) + 50;
        String[] booknames = new String[]{"解忧杂货店", "百年孤独", "白夜行", "遥远的救世主", "房思琪的初恋乐园", "云边有个小卖部",
                "嫌疑人X的献身", "霍乱时期的爱情", "岛上书店", "红楼梦", "苏菲的世界", "偷影子的人", "杀死一只知更鸟", "红岩"
        };

        String[] author = new String[]{"东野圭吾 ", "加西亚·马尔克斯", "东野圭吾", "豆豆 "};

        String[] classify = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        for (int i = 0; i < booknames.length; i++) {
            Book books = new Book();
            books.setAuthor(booknames[i]);
            books.setBookName(author[i]);
            books.setClassifyNum(classify[(int) (Math.random() * 10)]);
            books.setIsbn(generateRandomStr(13));
        }

    }

    public static String generateRandomStr(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            String randomStr = String.valueOf(random.nextInt(9));
            sb.append(randomStr);
        }
        return sb.toString();
    }
    @Test
    public void pro()
    {
        BorrowBookService service = new BorrowBookService();
        List<List<?>> list = service.pro(101);
        System.out.println(list.size());
    }

}
