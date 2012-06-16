package trans;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_sglr.*;
import org.strategoxt.stratego_gpp.*;
import org.strategoxt.stratego_xtc.*;
import org.strategoxt.stratego_aterm.*;
import org.strategoxt.stratego_sdf.*;
import org.strategoxt.strc.*;
import org.strategoxt.imp.editors.template.generated.*;
import org.strategoxt.java_front.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class throw_$Is$Imported_1_1 extends Strategy 
{ 
  public static throw_$Is$Imported_1_1 instance = new throw_$Is$Imported_1_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy j_10733, IStrategoTerm i_10733)
  { 
    context.push("throw_IsImported_1_1");
    Fail180:
    { 
      IStrategoTerm l_10733 = null;
      l_10733 = term;
      term = dr_throw_1_2.instance.invoke(context, l_10733, j_10733, i_10733, trans.const5);
      if(term == null)
        break Fail180;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}