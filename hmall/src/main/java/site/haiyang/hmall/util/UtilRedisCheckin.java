package site.haiyang.hmall.util;

import java.util.*;

public class UtilRedisCheckin {

    //存储中奖记录
    public static boolean putWeekCheckin(Long userId,String dateStr) {

        Calendar calendar = Calendar.getInstance();
        //手动设置日期
        Date manuDate = DateUtil.format(dateStr,"yyyy-MM-dd");
        calendar.setTime(manuDate);

        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        //允许覆盖式签到，但是还是要提示给用户，但是通过前端读取的列表提示，如果用户恶意刷入则不管
//        List list = redisManager.lrang("checkin_week_"+weekOfYear + "_"+userId,0,-1);
        if(calendar.get(Calendar.DAY_OF_WEEK) == 1){
            calendar.add(Calendar.DATE, -1);
            weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
            dayOfWeek = 7;
        }else{
            dayOfWeek --;
        }
        String weekAndDate = dayOfWeek+","+DateUtil.format(new Date(),"yyyy-MM-dd");
        long flag = UtilsJedis.lpush("checkin_week_"+weekOfYear + "_"+userId, weekAndDate,168*3600);
        return flag>0;
    }

}