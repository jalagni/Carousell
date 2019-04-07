package com.carousell.domain;


import android.content.Context;

import com.carousell.domain.utils.DomainHelper;

import org.junit.Test;
import org.mockito.Mock;

public class UnitDomainTest {

    @Mock
    Context context;

    @Test
    public void httpCodeTest() {
//        boolean state = HttpUtils.isValidResponse(200);
//        Assert.assertTrue(state);
//
//        state = HttpUtils.isValidResponse(204);
//        Assert.assertTrue(state);
//
//        state = HttpUtils.isValidResponse(400);
//        Assert.assertFalse(state);
//
//        state = HttpUtils.isValidResponse(404);
//        Assert.assertFalse(state);


        DomainHelper.getReadableDate(context,1551954718);

    }
}
