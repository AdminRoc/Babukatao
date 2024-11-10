/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.datetimepicker;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import com.nineoldandroids.view.animation.AnimatorProxy;

import org.holoeverywhere.widget.Button;
import org.holoeverywhere.widget.LinearLayout;

/**
 * Fake Button class, used so TextViews can announce themselves as Buttons, for accessibility.
 */
public class AccessibleLinearLayout extends LinearLayout {
    private final AnimatorProxy mProxy = AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(this) : null;

    public AccessibleLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setClassName(Button.class.getName());
    }

    @Override
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(Button.class.getName());
    }

    @Override
    public float getScaleX() {
        if (mProxy != null) {
            return mProxy.getScaleX();
        } else {
            return super.getScaleX();
        }
    }

    @Override
    public void setScaleX(float scaleX) {
        if (mProxy != null) {
            mProxy.setScaleX(scaleX);
        } else {
            super.setScaleX(scaleX);
        }
    }

    @Override
    public float getScaleY() {
        if (mProxy != null) {
            return mProxy.getScaleY();
        } else {
            return super.getScaleY();
        }
    }

    @Override
    public void setScaleY(float scaleY) {
        if (mProxy != null) {
            mProxy.setScaleY(scaleY);
        } else {
            super.setScaleY(scaleY);
        }
    }
}
