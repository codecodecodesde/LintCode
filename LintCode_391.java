/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
class Point{
    int time;
    int event;
    public Point(int t, int e){
        this.time = t;
        this.event = e;
    }
    
    public static Comparator<Point> PointComparator  = new Comparator<Point>(){
      public int compare(Point p1, Point p2){
        if(p1.time == p2.time) return p1.event - p2.event;
        else return p1.time - p2.time;
      }
    };
}

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        
        List<Point> events = new ArrayList<>();
        for(Interval i : airplanes){
            events.add(new Point(i.start, 1));
            events.add(new Point(i.end, 0));
        }
        
        int count = 0;
        int max = 0;
        Collections.sort(events, Point.PointComparator);
        for(Point p : events){
            if(p.event == 1){
                count++;
            }else{
                count--;
            }
            
            max = Math.max(max, count);
        }
        return max;
    }
}