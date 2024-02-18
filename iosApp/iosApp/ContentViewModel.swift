//
//  ContentViewModel.swift
//  iosApp
//
//  Created by Santiago Mattiauda on 18/2/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import Shared

@Observable
class ContentViewModel {
    
    private let keyShowText = "show_text"
    private let kvs: Kvs
    var text: String
    var showImage: Bool
    
    init(kvs: Kvs, text: String = "Hello world!") {
        self.kvs = kvs
        self.text = text
        self.showImage = kvs.getBoolean(key: keyShowText, defValue: false)
    }
    
    func onTap() {
        
        let isTapped = kvs.getBoolean(key: keyShowText, defValue: false)
        kvs.edit().putBoolean(key: keyShowText, value: !isTapped).apply()
        showImage = kvs.getBoolean(key: keyShowText, defValue: false)
        
        text = "SwiftUI: \(Greeting().greet())"
        
    }
    
}
