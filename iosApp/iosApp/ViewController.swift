import UIKit
import app

class ViewController: UIViewController, MainView {
    
    func displayData(data: AllData) {
        label.text = data.name
    }
    
    var isUpdating: Bool = false
    
    let repository = DataRepositoryImpl()
    
    lazy var presenter : MainPresenter = {
        MainPresenter(
        view: self,
        repository: repository)
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter.loadData(userName: "iamBedant")
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    @IBOutlet weak var label: UILabel!
}
