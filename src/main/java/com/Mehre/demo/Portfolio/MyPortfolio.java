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
            <h2>Skills</h2>
            <h3>Programming Languages</h3>
            <ul>
                <li>Java</li>
                <li>C++</li>
            </ul>
            <h4>Frontend</h4>
            <ul>
                <li>HTML5</li>
                <li>CSS3</li>
            </ul>
            <h3>Backend</h3>
            <ul>
                <li>Spring Boot</li>
            </ul>
            <h3>Databases</h3>
            <ul>
                <li>MySQL</li>
            </ul>
            <h3>DevOps & Cloud</h3>
            <ul>
                <li>Git & GitHub</li>
                <li>Docker</li>
                <li>Jenkins</li>
                <li>GitHub Actions</li>
                <li>AWS EC2</li>
            </ul>
            <h3>Cybersecurity</h3>
            <ul>
                <li>Nmap</li>
                <li>Wireshark</li>
                <li>Metasploit</li>
            </ul>
            """;

}



















}
