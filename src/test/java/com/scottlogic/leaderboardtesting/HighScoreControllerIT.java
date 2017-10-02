package com.scottlogic.leaderboardtesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestApplicationConfig.class })
@WebAppConfiguration
public class HighScoreControllerIT {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void get_Returns_200() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/api/highscores"))
            .andDo(print()).andExpect(status().isOk())
            .andReturn();

        Assert.assertEquals("application/json;charset=UTF-8", mvcResult.getResponse().getContentType());
    }

    @Test
    public void post_With_Valid_High_Score_Returns_200() throws Exception {
        RequestBuilder request = post("/api/highscores")
                            .content("{\n" +
                                    "\t\"userName\": \"test\",\n" +
                                    "\t\"gameName\": \"test\",\n" +
                                    "\t\"value\": 20\n" +
                                    "}\n")
                            .header("Content-Type", "application/json");
        MvcResult mvcResult = this.mockMvc.perform(request)
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void post_With_Invalid_GameName_Returns_400() throws Exception {
        RequestBuilder request = post("/api/highscores")
                .content("{\n" +
                        "\t\"value\": 20, \n" +
                        "\t\"gameName\": null, \n" +
                        "\t\"userName\": \"test\"\n" +
                        "}")
                .header("Content-Type", "application/json");
        MvcResult mvcResult = this.mockMvc.perform(request)
                .andDo(print()).andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void post_With_Invalid_UserName_Returns_400() throws Exception {
        RequestBuilder request = post("/api/highscores")
                .content("{\n" +
                        "\t\"value\": 20, \n" +
                        "\t\"gameName\": \"test\", \n" +
                        "\t\"userName\": null\n" +
                        "}")
                .header("Content-Type", "application/json");
        MvcResult mvcResult = this.mockMvc.perform(request)
                .andDo(print()).andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void post_With_Invalid_Value_Returns_400() throws Exception {
        RequestBuilder request = post("/api/highscores")
                .content("{\n" +
                        "\t\"value\": 55, \n" +
                        "\t\"gameName\": \"test\", \n" +
                        "\t\"userName\": \"test\"\n" +
                        "}")
                .header("Content-Type", "application/json");
        MvcResult mvcResult = this.mockMvc.perform(request)
                .andDo(print()).andExpect(status().isBadRequest())
                .andReturn();
    }
}
