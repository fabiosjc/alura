/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  Platform,
  StyleSheet,
  Text,
  View,
  Image,
  Dimensions,
  FlatList
} from 'react-native';

const width = Dimensions.get('screen').width;
const fotos = [
  {id:1, usuario: 'fabio'}, 
  {id:2, usuario: 'alex'}, 
  {id:3, usuario: 'vitor'}
];

export default class App extends Component {
  render() {
    return (
      <FlatList style={{marginTop: 20}}
        keyExtractor={item => item.id}
        data={fotos}
        renderItem={ ({item}) => 
          <View>
            <Text>{item.usuario}</Text>
            <Image source={require('./resources/img/alura.jpg')} style={{width:width, height:width}} />
          </View>
        }
      />
    );
  }
}