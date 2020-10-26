package neil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import lombok.Data;

/* Amended by Neil
 */
@Data
public class AnObject implements Serializable /*, Comparable<AnObject>, SomeInterface */ {

    //private static final long serialVersionUID = someLongVal;
    private static final long serialVersionUID = 1L;

    private Long aLongField1;

    private Long aLongField2;

    private Long aLongField3;

    private Long aLongField4;

    private Long aLongField5;

    private LocalDateTime aLocalDateTimeField1;

    private LocalDateTime aLocalDateTimeField2;

    private Enum1 anEnumField1;

    private String aStringField1;

    private Enum2 anEnumField2;

    private BigDecimal aBigDecimalField1;

    private BigDecimal aBigDecimalField2;

    private String aStringField2;

    private BigDecimal aBigDecimalField3;

    private String aStringField3;

    private AnObject2 anObjectField1; //simple 4 String field object

    private String aStringField4;

    private AnObject2 anObjectField2;  //simple 4 String field object

    private AnObject2 anObjectField3;  //simple 4 String field object

    private String aStringField5;

    private BigDecimal aBigDecimalField4;

    private Long aLongField6;

    private String aStringField6;

    private String aStringField7;

    private Long aLongField7;

    private Long aLongField8;

    private Long aLongField9;

    //FIXME Suspicion is on this
    private List<AnObject> anObjectField4; //AnObject of the same type as this class(!!!)

    private Set<AnObject3> anObjectField5; //a bit more complex - it consists fields SomeClass(with 3 simple fields), 4 long fields, 1 enum, 1 BigDecimal, 3 string fields

    private Boolean aBooleanField1;

    private Long aLongField10;
}