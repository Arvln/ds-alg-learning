class MyCalendarThree {
    map<int, int>Map;
public:
    MyCalendarThree() {

    }

    int book(int startTime, int endTime) {
        Map[startTime]+=1;
        Map[endTime]-=1;

        int sum=0, ret=0;
        for (auto [time, diff] : Map)
        {
            sum+=diff;
            ret=max(ret, sum);
        }
        return ret;
    }
};

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree* obj = new MyCalendarThree();
 * int param_1 = obj->book(startTime,endTime);
 */