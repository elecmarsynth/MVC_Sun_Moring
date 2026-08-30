import controllers.electionController;
import model.election;
import views.electionView;

public class Main {
    public static void main(String[] args) {
        election model = new election();
        electionView view = new electionView();
        electionController controller = new electionController(model, view);

        controller.start();
    }
}
