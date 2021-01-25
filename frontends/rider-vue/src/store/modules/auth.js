/* eslint-disable */



const state = {
    loggedIn: false,

    refreshToken: false,
    authenticationToken: false,
    email: false

};

const getters = {
    getLoggedIn: state => state.loggedIn,
    getAuthToken: state => state.authenticationToken,
    getEmail: state => state.email

};

const actions = {

    async setAuthToken({commit},tokens){
        
        commit("setAccessToken", tokens)
    },

};



const mutations = {

    setAccessToken:(state, tokens) => {//token, idToken) => {
        state.loggedIn = true;
        state.authenticationToken = tokens.authenticationToken;
        state.refreshToken = tokens.refreshToken;
        state.email = tokens.email;
    }
};

export default {
  state,
  getters,
  actions,
  mutations
};
