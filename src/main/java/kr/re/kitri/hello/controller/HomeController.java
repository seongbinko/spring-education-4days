package kr.re.kitri.hello.controller;


import kr.re.kitri.hello.model.Product;
import kr.re.kitri.hello.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired private ProductService productService;

    @GetMapping("/products/{productId}")
    public Map<String, Object> getProductDetailsByProductId(
            @PathVariable int productId) {

        System.out.println(productId);
        Product p = productService.viewProductDetail(productId);
        Map<String,Object> result = new HashMap<>();
        result.put("status","ok");
        result.put("data",p);

        return result;
    }

    @GetMapping("/products")
    public String getProducts() {
        //1. 요청을 해석.. 요청파라미터 확보, 헤더값을 확보
        //5. 결과값을 받아서 JSON 포맷을 만들어서 전송 (응답)

        //1000번을 요청시 1000번의 객체 생성 메모리 부하, 가비지 컬렉터에서 내려오기전에도 계속 요청
        // 객체 생성을 안해서 nullpointException이 날것 같지만 @Autowired로 인해서 의존성 주입을 받아서 필요할 때 사용할 수 있다.
        // 스프링 -> 컴포넌트를 메모리에 다 올려 놓고 시작 요청이 왔을 때 바로하게
        // 라이프사이클관리 -> 요청이많으면 풀을 늘리고 줄이면 관리를 알아서 한다.
        return productService.retrieveProducts();
    }

    @GetMapping("/products/hello")
    public String hello() {
        return "hello";
    }
}
