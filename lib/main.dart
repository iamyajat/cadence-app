import 'package:flutter/material.dart';

void main() => runApp(
  MyApp()
);

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Welcome to Flutter',
      theme: ThemeData(
        // accentColor: Colors.white,
        primaryColor: Colors.white,
        fontFamily: 'Metropolis',
        // elevatedButtonTheme: ElevatedButtonThemeData(
        //     style: ElevatedButton.styleFrom(
        //       primary: Colors.purple,
        //     ),
        //   ),
        
        ),
      home: Playlist(),
    );
  }
}




class Playlist extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        // appBar: AppBar(
        //   title: Text('Welcome to Flutter'),
        // ),
        backgroundColor: Colors.black,
        body: Container(
          padding: EdgeInsets.all(50),
          child: Column(children: [

            Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
            Text(
            'Synced \nplaylists',
              style: TextStyle(
                color: Colors.white,
                fontSize: 36,
                fontWeight: FontWeight.w700,
                fontFamily: 'Metropolis',
                // fontStyle: FontStyle.italic
              ),
               
          ),
          IconButton(
          iconSize: 35,
          icon: Icon(Icons.cached,
          color: Colors.white,
          
          
          ),
          tooltip: 'Increase volume by 10',
          onPressed: () {
          },
        ),
          ],),

          // search bar
          Padding(
            padding: EdgeInsets.fromLTRB(10, 50, 10, 40),
            child:TextField(
              decoration: InputDecoration(
                // border: InputBorder.,  
                hintText: 'Enter a search term',
                hintStyle: TextStyle(  
                  color: Colors.grey  
                  // fontStyle: FontStyle,
                ),
              ),
            ),
          
          ),
          
            //list
            // ListView(
            //   children: const <Widget>[
            //     Card(child: ListTile(title: Text('One-line ListTile'))),
            //     Card(
            //       child: ListTile(
            //         leading: FlutterLogo(),
            //         title: Text('One-line with leading widget'),
            //       ),
            //     ),
            //     Card(
            //       child: ListTile(
            //         title: Text('One-line with trailing widget'),
            //         trailing: Icon(Icons.more_vert),
            //       ),
            //     ),
            //     Card(
            //       child: ListTile(
            //         leading: FlutterLogo(),
            //         title: Text('One-line with both widgets'),
            //         trailing: Icon(Icons.more_vert),
            //       ),
            //     ),
            //     Card(
            //       child: ListTile(
            //         title: Text('One-line dense ListTile'),
            //         dense: true,
            //       ),
            //     ),
            //     Card(
            //       child: ListTile(
            //         leading: FlutterLogo(size: 56.0),
            //         title: Text('Two-line ListTile'),
            //         subtitle: Text('Here is a second line'),
            //         trailing: Icon(Icons.more_vert),
            //       ),
            //     ),
            //     Card(
            //       child: ListTile(
            //         leading: FlutterLogo(size: 72.0),
            //         title: Text('Three-line ListTile'),
            //         subtitle: Text(
            //           'A sufficiently long subtitle warrants three lines.'
            //         ),
            //         trailing: Icon(Icons.more_vert),
            //         isThreeLine: true,
            //       ),
            //     ),
            //   ],
            // ),


            ElevatedButton(
              child: Text('Confirm'),
              style: ElevatedButton.styleFrom(
                primary: Colors.blue,
                padding: EdgeInsets.fromLTRB(60, 15, 60, 15),
                shape: const BeveledRectangleBorder(borderRadius: BorderRadius.all(Radius.circular(5))),
                elevation: 5,
                textStyle: TextStyle(
                color: Colors.black,
                fontSize: 20,
                fontWeight: FontWeight.bold,
                fontFamily: 'Metropolis',
                // fontStyle: FontStyle.italic
      ),
              ),
              onPressed: () {
                print('Pressed');
              },
            )
          ],)
          ),
      );
  }
}