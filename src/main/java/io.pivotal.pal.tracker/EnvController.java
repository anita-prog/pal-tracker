package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String port;
    private String memoryLimit;
    private String cfInstanceIndex;
    private String cfInstanceAddr;

    @GetMapping("/env")
    public Map<String, String> getEnv() throws Exception {
        Map<String, String> env = new HashMap<>();

        env.put("PORT", port);
        env.put("MEMORY_LIMIT", memoryLimit);
        env.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        env.put("CF_INSTANCE_ADDR", cfInstanceAddr);

        return env;
    }


         public EnvController(@Value("${port:8675}") String port,
                @Value("${memory.limit:12G}")  String memoryLimit,
                @Value("${cf.instance.index:34}") String cfInstanceIndex,
                @Value("${cf.instance.addr:123.sesame.street}") String cfInstanceAddr)
        {

            this.port = port;
            this.memoryLimit = memoryLimit;
            this.cfInstanceIndex = cfInstanceIndex;
            this.cfInstanceAddr = cfInstanceAddr;
        }
}
