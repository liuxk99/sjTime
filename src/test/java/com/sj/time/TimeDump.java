package com.sj.time;

import java.util.Date;

class TimeDump {
    static void dump(Date date) {
        System.out.println(date.getClass().getSimpleName() + ": {" + date + "}");
    }
}
