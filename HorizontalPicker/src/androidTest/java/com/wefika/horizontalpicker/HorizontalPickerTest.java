/*
 * Copyright 2014 Blaž Šolar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wefika.horizontalpicker;

import android.test.AndroidTestCase;
import android.view.KeyEvent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Blaž Šolar on 20/04/14.
 */
public class HorizontalPickerTest extends AndroidTestCase {

    public void testKeyEventDpadCenter() throws Exception {

        final CountDownLatch mLock = new CountDownLatch(1);

        HorizontalPicker view = new HorizontalPicker(getContext());
        view.setValues(new String[]{"Item 1", "Item 2", "Item 3"});
        view.setOnItemSelectedListener(new HorizontalPicker.OnItemSelected() {
            @Override
            public void onItemSelected(int index) {
                mLock.countDown();
            }
        });
        view.onKeyDown(KeyEvent.KEYCODE_DPAD_CENTER, null);

        if (!mLock.await(1000, TimeUnit.MILLISECONDS)) {
            fail();
        }

    }

    public void testKeyEventEnter() throws Exception {

        final CountDownLatch mLock = new CountDownLatch(1);

        HorizontalPicker view = new HorizontalPicker(getContext());
        view.setValues(new String[]{"Item 1", "Item 2", "Item 3"});
        view.setOnItemSelectedListener(new HorizontalPicker.OnItemSelected() {
            @Override
            public void onItemSelected(int index) {
                mLock.countDown();
            }
        });
        view.onKeyDown(KeyEvent.KEYCODE_ENTER, null);

        if (!mLock.await(1000, TimeUnit.MILLISECONDS)) {
            fail();
        }

    }

}
