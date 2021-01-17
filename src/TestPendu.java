public class TestPendu {

    public static void main(String[] args){

        JeuPendu pnd = new JeuPendu();

        pnd.choisieModeJeu();
        do {
            switch(pnd.ModeJeu) {
                case 1:
                    pnd.mode1();
                    break;
                case 2:
                    pnd.mode2();
                    break;
            }
        } while (pnd.Decision != 0);
    }
}
