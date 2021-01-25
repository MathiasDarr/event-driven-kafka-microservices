<template>
  <v-container>
    <v-layout row>
      <v-flex md2>

      </v-flex> 
      <v-flex md10>
        <div class="title font-weight-medium">
          <v-layout row>
            <v-flex md8>

        <v-btn color="primary" @click="postRideRequest"> Request Ride</v-btn>

  <div>

    <label>
      AutoComplete

      <GmapAutocomplete @place_changed="usePlace">
      </GmapAutocomplete>
      <button @click="usePlace">Add</button>

    </label>
    <br/>

    <GmapMap style="width: 600px; height: 400px;" :zoom="13" :center="{lat: 47.77, lng: -122.33}">

      <GmapMarker v-for="(marker, index) in markers"
        :key="index"
        :position="marker.position"
        />

      <GmapMarker
        v-if="this.place"
        label="★"
        :position="{
          lat: this.place.geometry.location.lat(),
          lng: this.place.geometry.location.lng(),
        }"
        />

    </GmapMap>

          </div>


            </v-flex>

            <v-flex md4>
              <v-card  tile  >
                <v-card-title>
                  Rides 
                </v-card-title>
              </v-card>
            </v-flex>
          </v-layout>
        
        </div>
      </v-flex>

    </v-layout> 
  </v-container>
</template>

<script>
/* eslint-disable */
import { mapGetters } from "vuex";


import axios from 'axios';

export default {
  
  components:{


  },

  methods:{
    getUserEmail(){
        var jwtDecode = require('jwt-decode');
        var decoded_token = jwtDecode(this.getIdToken)
        return decoded_token.email.split('@')[0]
    },
    async postRideRequest(){
        console.log("WERDF")
        var url = "http://localhost:8096/rides/requests"

        const response = await axios.get(url, {
            headers: {
              Authorization: 'Bearer ' + this.getAuthToken
            }
        })
        console.log(response)
    },

    setDescription(description) {
      this.description = description;
    },

    setPlace(place) {
      this.place = place
    },

    usePlace() {

      this.markers.push({
        position: {
        lat: 47.77,
        lng: -122.33,
        }
      })
    }
        
  },

  created(){
    var name = "mddarr@gmail.com"
    var split = name.split("@")
    console.log("Welcome " + split[0])
    console.log("welcome..")
    console.log("THE EMAI LIS " + this.getEmail)

  },
  data(){
    return {
      markers: [],
      place: null,
    }
  },
  computed: {
    ...mapGetters(["getEmail", "getAuthToken"]),

  },
}
</script>

<style>
code {
  font-family: Consolas,"courier new";
  color: crimson;
  background-color: #f1f1f1;
  padding: 2px;
  font-size: 105%;
}
</style>