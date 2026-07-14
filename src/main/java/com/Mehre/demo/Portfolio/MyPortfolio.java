package com.Mehre.demo.Portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MyPortfolio {
    @GetMapping("/mySelf")
    public String Myself() {
    return """
            <h1> Myself</h1>
            <p> Hey, I'm Mehre </p>
            <ul>
            <li> https://github.com/mehre-nigaar-shaik </li>
            <li> https://leetcode.com/u/Mehrenigaar_310/</li>
            </ul>
            """;

}



















}
