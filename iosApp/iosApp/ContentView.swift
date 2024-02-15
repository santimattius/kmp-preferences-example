import SwiftUI
import Shared

struct ContentView: View {
    
    let kvs = Kvs(definition: KvsDefinition(name: "", encrypted: false))
    var body: some View {
        VStack {
            
            Image(systemName: "swift")
                .imageScale(.large)
                .foregroundColor(.accentColor)
            Text("SwiftUI: \(Greeting().greet())")
        }
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
