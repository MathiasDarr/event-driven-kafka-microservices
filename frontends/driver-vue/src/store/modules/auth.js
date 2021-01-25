/* eslint-disable */

// import axios from 'axios';

import axios from 'axios';


const state = {
    loggedIn: false,
    cognitoInfo:{},
    loadingState:true,
    errorLoadingState:false,
    access_token: false,
    idToken: false,
    email: false

};

const getters = {
    getJwtAccessToken: state => state.access_token,
    getLoggedIn: state => state.loggedIn,
    getIdToken: state => state.idToken,
    getEmail: state => state.email

};

const actions = {

    async setJWT({commit}, tokens){
        console.log("Token " + tokens.access)
        console.log("id token " + tokens.id)
        commit('setAccessToken', tokens)
    },


    async setEmail({commit}, email){
        console.log("The incoming emai lis " + email)
        commit('setEmail', email)
    },

    async authentication({commit}, email, password){

    },


    async registration({commit}){

    

      },
};



const mutations = {
    setLoggedIn: (state, newValue) => { state.loggedIn = newValue;},
    setEmail:(state, email) => (state.email= email),
    setLoggedOut:(state) => {
        state.loggedIn=False; state.cognitoInfo = {}},
    setCognitoInfo:(state, newValue) => (state.cognitoInfo= newValue),
    setAccessToken:(state, tokens) => {//token, idToken) => {
        state.loggedIn = true;
        state.access_token = tokens.acces;
        state.idToken = tokens.id
    }
};

export default {
  state,
  getters,
  actions,
  mutations
};
