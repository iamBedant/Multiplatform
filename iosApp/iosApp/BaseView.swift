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
    
    public func showError(error: KotlinThrowable) {
        var title: String = "Error"
        var errorMessage: String? = nil
        var popupMessage: String? = nil
        
        switch error {
        case is Unauthorized:
            errorMessage = "Unauthorized"
        case is CannotFavorite:
            errorMessage = "Cannot set favorite now"
        case is UpdateProblem:
            let text = "Failed to get data from server, please check your internet connection"
            if(firstUpdateError) {
                errorMessage = text
                firstUpdateError = false
            } else {
                popupMessage = text
            }
        default:
            errorMessage = "Unknown Error"
        }
        
        if let message = errorMessage {
            self.showError(title: title, message: message)
        }
        if let message = popupMessage {
//            self.showPopupText(title: message)
        }
    }
    
    func showError(title: String, message: String) {
        let alertController = UIAlertController(title: title, message: message, preferredStyle: UIAlertControllerStyle.alert)
        alertController.addAction(UIAlertAction(title: "Dismiss", style: UIAlertActionStyle.default,handler: nil))
        self.present(alertController, animated: true, completion: nil)
    }
}

