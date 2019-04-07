package com.carousell.data;

import com.carousell.data.utils.HttpUtils;

import org.junit.Assert;
import org.junit.Test;

public class UnitApiService {

    @Test
    public void httpCodeTest() {
        boolean state = HttpUtils.isValidResponse(200);
        Assert.assertTrue(state);

        state = HttpUtils.isValidResponse(204);
        Assert.assertTrue(state);

        state = HttpUtils.isValidResponse(400);
        Assert.assertFalse(state);

        state = HttpUtils.isValidResponse(404);
        Assert.assertFalse(state);


    }
}
