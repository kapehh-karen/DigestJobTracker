package me.kapehh.DigestJobTracker.Controllers;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/info")
    public Map<String, Object> getInfo() {
        Map<String, Object> ret = new HashMap<>();
        ret.put("users", UserController.getUsers());
        return ret;
    }
}
