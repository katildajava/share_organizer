public abstract class Service {
    enum Coloring{
        CONSULTING(20), BLONDE_OUTGROWTH(95), BLONDE_SHORT_HAIR(105), BLONDE_MEDIUM_HAIR(125),
        BLONDE_LONG_HAIR(160), COLORING_SHORT_HAIR(65), COLORING_MEDIUM_HAIR(75), COLORING_LONG_HAIR(100),
        TONING(30), MENS_HAIR_COLORING(65);
        private final int price;
        Coloring(int price){
            this.price = price;
        }
        public int getPrice() {
            return price;
        }

    }
    enum MenHaircut{
        MACHINE_CUT(23), SCISSORS_CUT(30), BEARD_AND_MUSTACHE(15), HAIR_TATTOO(20);
        private final int price;
        MenHaircut(int price){
            this.price = price;
        }
        public int getPrice() {
            return price;
        }
    }
    enum WomenHaircut{
        HAIRCUT(45),HOT_SCISSORS_CUT(50),STYLE_CHANGE(50), ENDS(30), BANG(10);
        private final int price;
        WomenHaircut(int price){
            this.price = price;
        }
        public int getPrice() {
            return price;
        }
    }
    enum ForChildren{
        BOYS_HAIRCUT(25),GIRLS_HAIRCUT(30), GIRLS_ENDS_CUT(20);
        private final int price;
        ForChildren(int price){
            this.price = price;
        }
        public int getPrice() {
            return price;
        }
    }
    Coloring coloring;
    MenHaircut menHaircut;
    WomenHaircut womenHaircut;
    ForChildren forChildren;
    Service(Coloring coloring){
        this.coloring = coloring;
    }
    Service(MenHaircut menHaircut){
        this.menHaircut = menHaircut;
    }
    Service(WomenHaircut womenHaircut){
        this.womenHaircut = womenHaircut;
    }
    Service(ForChildren forChildren){
        this.forChildren = forChildren;
    }
    abstract void makeBooking();
/*    public boolean registerService(){
        return Service.findService("haircut");
    }
    public boolean updatePrice(){
        return findService("haircut").update(this);
    }*/

    /*    public boolean removeService(){
        return Service.remove(this);
    }
    public static Service findService(String name){
        return Service.find(name);
    }*/
}
