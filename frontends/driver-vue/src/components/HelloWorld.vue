<template>
  <v-container>

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

{{markers}}



  </v-container>
</template>

<script>
/* eslint-disable */
  export default {
    
    name: 'HelloWorld',

    data: () => ({
      map: null, 
      mapCenter: {lat: 47.773972, lng: -122.331297},
      markers: [{lat:47.773972, lng:-122.331297}]
   }),

    mounted(){

    },

    methods:{
      updateMarkerLocation(){

      }
    }


  }
</script>

<style scoped>
  #map {
    height:600px;
    background:gray;
  }
</style>
