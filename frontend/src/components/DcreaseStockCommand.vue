<template>

    <v-card outlined>
        <v-card-title>
            DcreaseStock
        </v-card-title>

        <v-card-text>
            <Number label="Qty" v-model="value.qty" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="dcreaseStock"
            >
                DcreaseStock
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'DcreaseStockCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.qty = 0;
        },
        watch: {
        },
        methods: {
            dcreaseStock() {
                this.$emit('dcreaseStock', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

