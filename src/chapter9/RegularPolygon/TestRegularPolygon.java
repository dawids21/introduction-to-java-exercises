package chapter9.RegularPolygon;

class TestRegularPolygon {
    public static void main(String[] args) {
        RegularPolygon[] polygons = new RegularPolygon[3];
        polygons[0] = new RegularPolygon();
        polygons[1] = new RegularPolygon(6, 4);
        polygons[2] = new RegularPolygon(10, 4, 5.6, 7.8);
        for (int i = 0; i < polygons.length; i++) {
            System.out.format(  "Polygon %d\nPerimeter: %.2f\nArea: %.2f\n\n",
                                i, polygons[i].getPerimeter(), polygons[i].getArea());
        }
    }    
}