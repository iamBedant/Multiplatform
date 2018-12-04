//
//  BaseView.swift
//  iosApp
//
//  Created by @iamBedant on 14/11/18.
//

import Foundation
import UIKit
import app

var firstUpdateError = true

extension UIViewController: BaseView {
    
    public func showError(error: String) {
        self.showError(title: "Error", message: error)
    }
    
    func showError(title: String, message: String) {
        let alertController = UIAlertController(title: title, message: message, preferredStyle: UIAlertControllerStyle.alert)
        alertController.addAction(UIAlertAction(title: "Dismiss", style: UIAlertActionStyle.default,handler: nil))
        self.present(alertController, animated: true, completion: nil)
    }
}

