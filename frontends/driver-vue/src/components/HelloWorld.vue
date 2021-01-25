<template>
  <v-container>
    <!-- <v-layout>
      <v-flex>
          <GmapMap
            :center="mapCenter"
            :zoom="14"
            map-type-id="terrain"
            style="width: 800px; height: 500px"
          >

        <GmapMarker
          :key="index"
          v-for="(m, index) in markers"
          :position="m.position"
          :clickable="true"
          :draggable="true"
          @click="center=m.position"
        />
      </GmapMap>
      </v-flex>
      <v-flex>
        <v-btn @click="requestRide">
            Request Ride
        </v-btn>

      </v-flex>
    </v-layout> -->

{{markers}}
        <v-btn @click="usePlace">
            Request Ride
        </v-btn>

  <div>

    <label>
      AutoComplete

      <GmapAutocomplete @place_changed="usePlace">
      </GmapAutocomplete>
      <button @click="usePlace">Add</button>

    </label>
    <br/>

    <GmapMap style="width: 600px; height: 300px;" :zoom="13" :center="{lat: 47.77, lng: -122.33}">

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
  </v-container>
</template>

<script>
/* eslint-disable */

import router from '../router'

export default {
  
  created(){

    var url = "http://localhost:8080/api/auth/login"
    var body = {email:"deb@gmail.com", password:"password"}


    axios.post(url, body).then((response) => {
      console.log(response)
    }, (error) => {
            
    console.log(error);
    });
  },
  
  components:{

  },

  data() {

    return {
      markers: [],
      place: null,
    }

  },

  description: 'Autocomplete Example (#164)',





methods: {

    setDescription(description) {
      this.description = description;
    },

    setPlace(place) {
      this.place = place
    },

    usePlace() {

        router.push('home')

if (true) {
        this.markers.push({
          position: {
            lat: 47.77,
            lng: -122.33,
          }
        })
      }
    }

  }

}

</script>


// /* eslint-disable */
//   export default {
    
//     name: 'HelloWorld',

//     data: () => ({
//       map: null, 
//       mapCenter: {lat: 47.773972, lng: -122.331297},
//       markers: []
//    }),

//     mounted(){

//     },

//     methods:{
//       requestRide(){
//         console.log("HELLO")
//         this.updateMarkerLocation()
//       },
//       updateMarkerLocation(){
//        this.markers.push({
//           position: {
//             lat: 47.773972,
//             lng: 122.331297
//           }
//         })

//       }
//     }
//   }
// </script>

<style scoped>
  #map {
    height:600px;
    background:gray;
  }
</style>
