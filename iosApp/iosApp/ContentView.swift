import SwiftUI
import Shared

struct ContentView: View {
    
    @State private var viewModel = ContentViewModel(
        kvs: Kvs(
            definition: KvsDefinition(
                name: "group.com.santimattius.kvs"
            )
        )
    )
    
    var body: some View {
        VStack {
            Text(viewModel.text)
            Button(viewModel.showImage ? "Hide" : "Show"){
                withAnimation {
                    viewModel.onTap()
                }
            }
            if(viewModel.showImage){
                Image("Swift")
                    .resizable()
                    .frame(width: 100, height: 100)
                    .transition(.scale)
            }
        }
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
