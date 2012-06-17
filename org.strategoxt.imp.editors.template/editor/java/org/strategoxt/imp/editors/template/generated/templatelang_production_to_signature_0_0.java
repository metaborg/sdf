package org.strategoxt.imp.editors.template.generated;

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

@SuppressWarnings("all") public class templatelang_production_to_signature_0_0 extends Strategy 
{ 
  public static templatelang_production_to_signature_0_0 instance = new templatelang_production_to_signature_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("templatelang_production_to_signature_0_0");
    Fail889:
    { 
      IStrategoTerm term334 = term;
      Success307:
      { 
        Fail890:
        { 
          TermReference a_32754 = new TermReference();
          TermReference b_32754 = new TermReference();
          TermReference c_32754 = new TermReference();
          TermReference d_32754 = new TermReference();
          TermReference e_32754 = new TermReference();
          IStrategoTerm f_32754 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
            break Fail890;
          IStrategoTerm arg216 = term.getSubterm(0);
          if(arg216.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg216).getConstructor())
            break Fail890;
          if(b_32754.value == null)
            b_32754.value = arg216.getSubterm(0);
          else
            if(b_32754.value != arg216.getSubterm(0) && !b_32754.value.match(arg216.getSubterm(0)))
              break Fail890;
          IStrategoTerm arg217 = arg216.getSubterm(1);
          if(arg217.getTermType() != IStrategoTerm.APPL || Main._consSingleLineTemplate_1 != ((IStrategoAppl)arg217).getConstructor())
            break Fail890;
          if(a_32754.value == null)
            a_32754.value = arg217.getSubterm(0);
          else
            if(a_32754.value != arg217.getSubterm(0) && !a_32754.value.match(arg217.getSubterm(0)))
              break Fail890;
          if(d_32754.value == null)
            d_32754.value = arg216.getSubterm(2);
          else
            if(d_32754.value != arg216.getSubterm(2) && !d_32754.value.match(arg216.getSubterm(2)))
              break Fail890;
          f_32754 = term;
          lifted250 lifted2500 = new lifted250();
          lifted2500.a_32754 = a_32754;
          lifted2500.b_32754 = b_32754;
          lifted2500.c_32754 = c_32754;
          lifted2500.d_32754 = d_32754;
          lifted2500.e_32754 = e_32754;
          term = with_spxverify_2_0.instance.invoke(context, term, lifted2500, lifted252.instance);
          if(term == null)
            break Fail890;
          term = f_32754;
          if(e_32754.value == null)
            break Fail890;
          term = e_32754.value;
          if(true)
            break Success307;
        }
        term = term334;
        IStrategoTerm term335 = term;
        Success308:
        { 
          Fail891:
          { 
            TermReference t_32753 = new TermReference();
            TermReference u_32753 = new TermReference();
            TermReference v_32753 = new TermReference();
            TermReference w_32753 = new TermReference();
            TermReference x_32753 = new TermReference();
            IStrategoTerm y_32753 = null;
            if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
              break Fail891;
            IStrategoTerm arg222 = term.getSubterm(0);
            if(arg222.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg222).getConstructor())
              break Fail891;
            if(u_32753.value == null)
              u_32753.value = arg222.getSubterm(0);
            else
              if(u_32753.value != arg222.getSubterm(0) && !u_32753.value.match(arg222.getSubterm(0)))
                break Fail891;
            IStrategoTerm arg223 = arg222.getSubterm(1);
            if(arg223.getTermType() != IStrategoTerm.APPL || Main._consTemplate_1 != ((IStrategoAppl)arg223).getConstructor())
              break Fail891;
            if(t_32753.value == null)
              t_32753.value = arg223.getSubterm(0);
            else
              if(t_32753.value != arg223.getSubterm(0) && !t_32753.value.match(arg223.getSubterm(0)))
                break Fail891;
            if(w_32753.value == null)
              w_32753.value = arg222.getSubterm(2);
            else
              if(w_32753.value != arg222.getSubterm(2) && !w_32753.value.match(arg222.getSubterm(2)))
                break Fail891;
            y_32753 = term;
            lifted253 lifted2530 = new lifted253();
            lifted2530.t_32753 = t_32753;
            lifted2530.u_32753 = u_32753;
            lifted2530.v_32753 = v_32753;
            lifted2530.w_32753 = w_32753;
            lifted2530.x_32753 = x_32753;
            term = with_spxverify_2_0.instance.invoke(context, term, lifted2530, lifted256.instance);
            if(term == null)
              break Fail891;
            term = y_32753;
            if(x_32753.value == null)
              break Fail891;
            term = x_32753.value;
            if(true)
              break Success308;
          }
          term = term335;
          IStrategoTerm s_32753 = null;
          s_32753 = term;
          term = templatelang_not_desugared_0_1.instance.invoke(context, s_32753, generated.const186);
          if(term == null)
            break Fail889;
        }
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}