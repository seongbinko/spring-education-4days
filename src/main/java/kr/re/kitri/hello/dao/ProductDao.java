package kr.re.kitri.hello.dao;

import kr.re.kitri.hello.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
    public String selectProducts() {
        // DB에 접속.. 쿼리 날려요..
        // Mybatis..
        // ...
        return "상품목록 받으세요..";
    }

    public Product selectProductById(int productId) {

        Product p = new Product("2005","아이폰11",500000,"iphone");

        return p;
    }

}
