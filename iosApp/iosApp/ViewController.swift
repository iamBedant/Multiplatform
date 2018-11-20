import UIKit
import app

class ViewController: UIViewController, MainView {
    
    func showLoader() {
        
    }
    
    func hideLoader() {
        
    }
    
    func displayData(data: DisplayData) {
        label.text = data.name
    }
    
    var isUpdating: Bool = false
    
    lazy var presenter : MainPresenter = {
        MainPresenter(view: self)
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
