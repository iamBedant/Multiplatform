//
//  UILayer+Color.swift
//  iosApp
//
//  Created by Mohit Anand on 03/12/18.
//

import Foundation
import UIKit

extension CALayer {
    
    var borderUIColor: UIColor {
        set {
            self.borderColor = newValue.cgColor
        }
        get {
            return UIColor(cgColor: self.borderColor!)
        }
    }
}
