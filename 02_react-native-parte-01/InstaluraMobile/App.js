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
import Post from './src/components/Post';

const fotos = [
  {id:1, usuario: 'fabio'}, 
  {id:2, usuario: 'alex'}, 
  {id:3, usuario: 'vitor'}
];

export default class App extends Component {
  render() {
    return (
      <FlatList style={styles.container}
        keyExtractor={item => item.id}
        data={fotos}
        renderItem={ ({item}) =>
          <Post item={item}/>
        }
      />
    );
  }
}

const styles = StyleSheet.create({
  container: {
      marginTop: 20,
  }
});