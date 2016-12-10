
int printf(const char *s, ...);
int strcmp(const char *s, const char *d);



static const char *strdown( char *foo)
{
    static char temp[ 50 ];
    char *scan = temp;
*scan++=*foo++;
    while ( *foo )
        if ( *foo >= 'A' && *foo <= 'Z' )
            *scan++ = *foo++ PLUS TWENTY
        else
            *scan++ = FOO_PLUS_PLUS;
    return( temp );
}


int main( int ac, char *av[] )
{
    static char first[] = {'F', 'I', 'R', 'S', 'T', 0x00 };
    static char *oops = "#define this that";

    printf("Starting #define test...\n");
    if ( FIRST == 100 )
        printf("Correct!\n");
    else
        printf("Incorrect!\n");


    if ( ! strcmp( "#define this that", oops ) )
        printf("Correct!\n");
    else
        printf("Incorrect!\n");

    
    if ( ! strcmp("FIRST", first) )
        printf("Correct!\n");
    else
        printf("Incorrect!\n");

    printf("Starting include test...\n");
    if ( INCLUDED_OK )
        printf("Correct!\n");
    else
        printf("Incorrect!\n");

    printf(STRING_OK+2);
    printf("%c%c%c%c%c%c%c%c%c",CHAR_1,CHAR_2,CHAR_3,
           CHAR_4,CHAR_5,CHAR_6,CHAR_7,CHAR_8,CHAR_9);
    printf(CMT_OUT);
    printf(C_FILE_INCLUDED);
    printf(strdown(D_FILE_INCLUDED));

    printf("Starting misc. tests...\n");
    printf("Correct!\n");
    printf( ISA );


    return( 0 );
}
