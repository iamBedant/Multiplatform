import UIKit
import app

class ViewController: UIViewController, MainView {
    
    func displayData(data: AllData) {
        <#code#>
    }
    
    var isUpdating: Bool = false
    
    let repository = DataRepositoryImpl()
//    let presenter = MainPresenter()
    
    override func viewDidLoad() {
        super.viewDidLoad()
//        label.text = Proxy().proxyHello()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    @IBOutlet weak var label: UILabel!
}
