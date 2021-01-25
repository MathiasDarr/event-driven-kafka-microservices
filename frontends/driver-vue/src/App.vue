<template>
  <v-app>
    

    <v-app-bar
      app
      color="secondary"
      dark
    >
      <div class="d-flex align-center">
        <v-img
          alt="Vuetify Logo"
          class="shrink mr-2"
          contain
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
          transition="scale-transition"
          width="40"
        />
      </div>

      <v-spacer>

      </v-spacer>
      
      
      <v-btn
        href="https://github.com/vuetifyjs/vuetify/releases/latest"
        target="_blank"
        text
      >
        <span class="mr-2">Welcome Driver</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn>
    </v-app-bar>


    <v-main>
      <HelloWorld/>
    </v-main>


  <v-container fluid>
    <v-row align="center">
      <v-col cols="6">
        <v-subheader>
          Custom items
        </v-subheader>
      </v-col>

      <v-col cols="6">
        <v-select
          v-model="select"
          :hint="`${select.state}, ${select.abbr}`"
          :items="items"
          item-text="state"
          item-value="abbr"
          label="Select"
          persistent-hint
          return-object
          single-line
        ></v-select>
      </v-col>
    </v-row>
  </v-container>

  </v-app>
</template>

<script>


import HelloWorld from './components/HelloWorld';

export default {
  name: 'App',

  components: {
    HelloWorld,

  },

  data(){
    return {
        activate: true,
        theme: 1,
        themes: [{
                text: "Dark",
                icon: "mdi-clock"
            },
            {
                text: "Light",
                icon: "mdi-account"
            }
        ],
        mini: true,
        services: [{
                icon: "mdi-domain",
                title: "Media Monitoring",
                link: "/mmrservices"
            },
            {
                icon: "mdi-message-text",
                title: "Audience Measurement",
                link: "/amrservices"
            },
            {
                icon: "mdi-flag",
                title: "Integration Analysis"
            }
        ],



        select: { state: 'Florida', abbr: 'FL' },
        items: [
          { state: 'Florida', abbr: 'FL' },
          { state: 'Georgia', abbr: 'GA' },
          { state: 'Nebraska', abbr: 'NE' },
          { state: 'California', abbr: 'CA' },
          { state: 'New York', abbr: 'NY' },
        ],

        drawer: false,
        menuItems:[
          {title:'Login', route:'/login/' }, 
        ],

        color: 'primary',
        colors: [
          'primary',
          'blue',
          'success',
          'red',
          'teal',
        ],
        right: false,
        permanent: false,
        miniVariant: false,
        expandOnHover: false,
        background: false,
      }
    },
};
</script>


<style>
  #map {
    height: 100%;
  }
  html, body {
    height: 100%;
    margin: 0;
    padding: 0;
  }
</style>

