public class LintCode_600 {
    /**
     * @param image a binary matrix with '0' and '1'
     * @param x, y the location of one of the black pixels
     * @return an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // Write your code here
        int mRow = image.length;
        int nCol = image[0].length;
        
        int left = findLeft(image, 0, y);
        int right = findRight(image, y, nCol - 1);
        int top = findTop(image, 0, x);
        int bottom = findBottom(image, x, mRow - 1);
        
        int area = (right - left + 1) * (bottom - top + 1);
        return area;
    }
    
    public boolean isEmptyCol (char[][] image, int mid){
        for(int i = 0; i < image.length; i++){
            if(image[i][mid] == '1')
                return false;
        }
        return true;
    }
    
    public boolean isEmptyRow(char[][] image, int mid){
        for(int i = 0; i < image[0].length; i++){
            if(image[mid][i] == '1'){
                return false;
            }
        }
        return true; 
    }
    
    public int findLeft (char[][] image, int start, int end){
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(isEmptyCol(image, mid)){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(isEmptyCol(image, start)){
            return end;
        }
        return start;
    }
    
    public int findRight (char[][] image,int start, int end){
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(isEmptyCol(image, mid)){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(isEmptyCol(image, end)){
            return start;
        }
        return end;
    }
    
    public int findTop (char[][] image, int start, int end){
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if(isEmptyRow(image, mid)){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(isEmptyRow(image, start)){
            return end;
        }
        return start;
    }
    
    public int findBottom (char[][] image, int start, int end){
        while (start + 1  < end){
            int mid = start+ (end - start) / 2;
            if (isEmptyRow(image, mid)){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(isEmptyRow(image, end)){
            return start;
        }
        return end;
    }
}